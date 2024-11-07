<template>
    <footer class="footer">
        <div class="footer-section">
            <h3 style="font-weight: bolder;">关于我们</h3>
            <ul>
                <li><a href="#">关于国泰集团</a></li>
                <li><a href="#">国泰应用程序</a></li>
                <li><a href="#" target="_blank">工作机会</a></li>
                <li><a href="#">我们对你的承诺</a></li>
                <li><a href="#" target="_blank">成为合作夥伴</a></li>
            </ul>
        </div>
        <div class="footer-section">
            <h3 style="font-weight: bolder;">法律及隐私声明</h3>
            <ul>
                <li><a href="#">法律及隐私声明</a></li>
                <li><a href="#" target="_blank">国泰航空载运条款及规则</a></li>
                <li><a href="#">现代奴役法案透明度声明</a></li>
                <li><a href="#">数码存根设置</a></li>
            </ul>
        </div>
        <div class="footer-section">
            <h3 style="font-weight: bolder;">协助与支持</h3>
            <ul>
                <li><a href="#">联系我们和常见问题</a></li>
                <li><a href="#">燃油附加费</a></li>
                <li><a href="#">可选服务和费用</a></li>
                <li><a href="#">网站帮助</a></li>
            </ul>
        </div>
        <div class="footer-section">
            <h3 style="font-weight: bolder;">让国泰跃升您生活每刻的体验</h3>
            <ul>
                <li><a href="#">航班</a></li>
                <li><a href="#">假期</a></li>
                <li><a href="#">购物</a></li>
                <li><a href="#">身心健旅</a></li>
                <li><a href="#">餐饮</a></li>
                <li><a href="#">支付</a></li>
            </ul>
        </div>
    </footer>
</template>

<script>
export default {
    name: "Foot"
};
</script>

<style scoped>
.footer {
    display: flex;
    background-color: #016b6c;
    color: #fff;
    padding: 20px;
    justify-content: space-around;
}

.footer-section {
    width: 20%;
}

.footer-section h3 {
    margin-bottom: 10px;
    font-size: 16px;
}

.footer-section ul {
    list-style: none;
    padding: 0;
}

.footer-section ul li {
    margin: 5px 0;
    font-size: 14px;
}

.footer-section ul li a {
    color: #fff;
    text-decoration: none;
}

.footer-section ul li a:hover {
    text-decoration: underline;
}
</style>
