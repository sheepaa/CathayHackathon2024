<template>
    <header class="header">
        <div class="header-content">
            <img class="logo" id="multilogo" src="../assets/homepage/icons/multilogo.png">
            <img class="logo" id="cathy" src="../assets/homepage/icons/cathy.png">
            <p class="title" id="title-left">国泰航空</p>

            <nav class="nav-links">
                <RouterLink class="link" to="/">首页</RouterLink>
                <RouterLink class="link" to="/other">航班</RouterLink>
                <RouterLink class="link" to="#">旅游</RouterLink>
                <RouterLink class="link" to="#">购物</RouterLink>
                <RouterLink class="link" to="#">保险</RouterLink>
                <RouterLink class="link" to="#">餐饮</RouterLink>
                <RouterLink class="link" to="#">支付</RouterLink>
                <RouterLink class="link" to="#">会籍</RouterLink>
            </nav>

            
            <p class="title" id="title-right">多式联运 · 全链条出行</p>
        </div>
    </header>
</template>

<script setup>
import { RouterLink } from 'vue-router';
</script>

<style>
.header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 70px;
    background: #f6f6f2;
    color: #016b6c;
    z-index: 1000;
    display: flex;
    align-items: center;
    padding: 0 15px;
}

.header-content {
    display: flex;
    align-items: center;
    width: 100%;
    justify-content: space-between;
}

.header .logo {
    position: absolute;
    top: 50%;
    height: 70px;
    transform: translate(0%, -50%);
}

.header #multilogo {
    right: 15px;
}

.header #cathy {
    left: 15px;
}

.nav-links {
    position: absolute;
    left: 220px;
    display: flex;
    gap: 20px;
    /* Adjust spacing between links as needed */
}

.link {
    font-size: 15px;
    color: black;
    text-decoration: none;
}

.title {
    position: absolute;
    color: #016b6c;
    font-size: 20px;
    top: 50%;
    transform: translate(0, -50%);
}

#title-left {
    left: 100px;
}

#title-right {
    right: 100px;
}
</style>