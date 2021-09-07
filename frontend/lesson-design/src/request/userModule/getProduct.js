import service from "../index";

export function getBigPic() {
    return service.request({
        url:`/v1/user/getUser`,
        method:`get`
    })
}