import service from '../index'

export function managerLogin(username,password) {
    return service.request({
        url:'/v1/manager/login',
        method:'post',
        data:{username,password}
    })
}
