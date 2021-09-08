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
