module.exports = {
    devServer: {
        port:3000,
        proxy:{
            '/v1/user':{
                target:'http://localhost:8080',
                withCredentials:true
            }
        }
    }
}