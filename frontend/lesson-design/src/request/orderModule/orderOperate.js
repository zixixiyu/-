import service from "../index";

export function certifyPay(productId,beginTime,endTime,productNum) {
    return service.request({
        url:'/v1/order/addOrder',
        method:"post",
        data:{productId,beginTime,endTime,productNum}

    })

}
export function getOrderByUsername(username,pageNum) {
    return service.request({
        url:'/v1/order/getOrder',
        method:'get',
        params:{username,pageNum}
    })

}

export function getOrderNumByUserName(username) {
    return service.request({
        url:'/v1/order/getOrderNum',
        method:'get',
        params:{username}
    })
}

export function getOrderItemByOrderId(orderId) {
    return service.request({
        url:'/v1/order/getOrderItem',
        method:'get',
        params:{orderId}
    })
}
