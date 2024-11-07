<template>
    <span>支付成功</span>
    <span>{{ seconds }}秒后返回首页</span>
</template>

<script setup>
import { useRouter } from 'vue-router'
import { onMounted, onUnmounted, ref } from 'vue'

const router = useRouter()
const seconds = ref(3)
let intervalId

onMounted(() => {
    console.log('PaymentSuccess mounted')
    intervalId = setInterval(() => {
        seconds.value--
    }, 1000)
    setTimeout(() => {
        router.push('/')
    }, 3000)
})

onUnmounted(() => {
    clearInterval(intervalId)
})
</script>