import service from "../index";

export function getAllUser(pageNum) {
    return service.request({
        url:'/v1/user/getAllUser',
        method:'get',
        params:{pageNum}
    })
}
export function getUserNum() {
    return service.request({
        url:'/v1/user/getUserNum',
        method:'get'
    })
}

export function distinctUsername(username) {
    return service.request({
        url:'/v1/user/distinct',
        method:'get',
        params:{username}

    })
}
export function registry(username,password,email,mobile) {
    return service.request({
        url:'/v1/user/registry',
        method:'post',
        data:{username,password,email,mobile}
    })
}
