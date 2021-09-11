import service from "../index";

export function certifyPay(productId,beginTime,endTime,productNum) {
    return service.request({
        url:'/v1/order/addOrder',
        method:"post",
        data:{productId,beginTime,endTime,productNum}

    })

}
