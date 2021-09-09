import axios from 'axios';
import {Message} from 'view-design';

// 创建一个错误
function errorCreate (msg) {
    const err = new Error(msg);
    errorLog(err);
    throw err;
}

// 记录和显示错误
function errorLog (err) {

    // 打印到控制台
    if (process.env.NODE_ENV === 'development') {
        console.log(err);
        Message.error(err.message)
    }

}

// 创建一个 axios 实例
const service = axios.create({
    baseURL: `http://localhost:3000`,
    timeout: 5000 // 请求超时时间
});

// 请求拦截器
service.interceptors.request.use(
    config => {
        config.withCredentials = true; // 开启跨域能力 是否携带cookie
        // 在请求发送之前做一些处理
        let uToken =  localStorage.getItem("uToken");
        if(uToken){
            //1.2 注意：给请求头里面添加u-token（后台判断就是取的这个请求头）请求头，并把随机数的token值也设置进去
            config.headers['u-token']=uToken;
        }
        // 让每个请求携带token-- ['X-Token']为自定义key 请根据实际情况自行修改
        let mToken =  localStorage.getItem("mToken");
        if(mToken){
            //1.2 注意：给请求头里面添加u-token（后台判断就是取的这个请求头）请求头，并把随机数的token值也设置进去
            config.headers['m-token']=mToken;
        }
        return config;
    },
    error => {
        // 发送失败
        console.log(error);
        Promise.reject(error);
    }
);

// 响应拦截器
service.interceptors.response.use(
    response => {
        // dataAxios 是 axios 返回数据中的 data
        const dataAxios = response.data;
        // 这个状态码是和后端约定的
        const { code } = dataAxios;
        // 根据 code 进行判断
        if (code === undefined) {
            // 如果没有 code 代表这不是项目后端开发的接口
            return dataAxios;
        } else {
            // 有 code 代表这是一个后端接口 可以进行进一步的判断
            switch (code) {
                case 200:
                    return dataAxios.data;
                case 498:
                    Message.error("非管理员无法查看");
                    break;
                case 499:
                    // [ 示例 ] 其它和后台约定的 code

                    Message.error("尚未登录系统，无法完成对应功能");

                    break;
                default:
                    // 不是正确的 code
                    errorCreate(`${dataAxios.message}: ${response.config.url}`);
                    break;
            }
        }
    },
    error => {
        if (error && error.response) {
            switch (error.response.status) {
                case 400: error.message = '请求错误'; break;
                case 401: error.message = '未授权，请登录'; break;
                case 403: error.message = '拒绝访问'; break;
                case 404: error.message = `请求地址出错: ${error.response.config.url}`; break;
                case 408: error.message = '请求超时'; break;
                case 500: error.message = '服务器内部错误'; break;
                case 501: error.message = '服务未实现'; break;
                case 502: error.message = '网关错误'; break;
                case 503: error.message = '服务不可用'; break;
                case 504: error.message = '网关超时'; break;
                case 505: error.message = 'HTTP版本不受支持'; break;
                default: break;
            }
        }
        errorLog(error);
        return Promise.reject(error);
    }
);

export default service;
