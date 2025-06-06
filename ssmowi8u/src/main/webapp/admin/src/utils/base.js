const base = {
    get() {
        return {
            url : "http://localhost:8080/ssmowi8u/",
            name: "ssmowi8u",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssmowi8u/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "在线课堂微信小程序"
        } 
    }
}
export default base
