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
export function shanxiajia(productName) {
    return service.request({
        url:'/v1/product/shanxiajia',
        method:'get',
        params:{productName}
    })

}
export function postImage(formData) {
    return service.request({
        url:'/v1/product/insertProduct',
        method:'post',
        headers:{
            'Content-Type': 'multipart/form-data'
        },
        data:formData
    })

}
export function frontGetProduct(category) {
    return service.request({
        url:'/v1/product/getFiveProduct',
        method:'get',
        params:{category}
    })
}
