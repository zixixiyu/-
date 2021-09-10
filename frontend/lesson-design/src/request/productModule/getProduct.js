import service from "../index";

export function getProductNum(){
    return service.request({
        url:'/v1/product/getNum',
        method:'get'
    })
}

export function getPageProduct(pageNum) {
    return service.request({
        url:'/v1/product/getPageProduct',
        method:'get',
        params:{pageNum}
    })
}
