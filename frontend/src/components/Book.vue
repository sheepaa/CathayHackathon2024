<template>
    <div>
        <!-- bootstrap buttons -->
        <div class="main-box">
            <button class="main-button">预定行程</button>
            <button class="main-button">管理行程</button>
            <button class="main-button">预办登机</button>
            <button class="main-button">查询航班状况</button>
        </div>

        <!-- Bootstrap button group -->
        <!-- 选择后 相应按钮需要高光 -->
        <div class="sub-box">
            <button class="sub-button">预定航班</button>
            <button class="sub-button">一票通</button>
            <button class="sub-button">兑换机票</button>
            <button class="sub-button">住宿</button>
            <button class="sub-button">套票</button>
        </div>

        <div>
            <div class="row">
                <div class="col">
                    <label for="departure">出发地点</label>
                    <select v-model="departure" class="form-select">
                        <option selected value="">请选择出发城市</option>
                        <option value="广州">广州</option>
                        <option value="深圳">深圳</option>
                        <option value="佛山">佛山</option>
                        <option value="东莞">东莞</option>
                        <option value="珠海">珠海</option>
                        <option value="中山">中山</option>
                        <option value="江门">江门</option>
                        <option value="惠州">惠州</option>
                        <option value="肇庆">肇庆</option>
                    </select>
                </div>
                <div class="col">
                    <label for="destination">目的地</label>
                    <select v-model="ticket.destination" class="form-select">
                        <option selected value="">请选择目的地</option>
                        <option value="东京成田机场">东京成田机场</option>
                        <option value="大阪关西机场">大阪关西机场</option>
                        <option value="名古屋中部机场">名古屋中部机场</option>
                        <option value="札幌新千岁机场">札幌新千岁机场</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label for="journeyType">旅程类别</label>
                    <select v-model="journeyType" class="form-select">
                        <option selected value="">往返</option>
                        <option value="单程">单程</option>
                    </select>
                </div>
                <div class="col">
                    <label for="date">客舱级别</label>
                    <select class="form-select">
                        <option selected value="">请选择客舱级别</option>
                        <option value="经济舱">经济舱</option>
                        <option value="公务舱">公务舱</option>
                        <option value="头等舱">头等舱</option>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <label for="date">出发日期</label>
                    <input type="date" v-model="ticket.departureTime" class="form-control">
                </div>
                <div class="col">
                    <label for="date">返回日期</label>
                    <input type="date" class="form-control" :disabled="disableReturn">
                </div>
            </div>
        </div>
        <!-- 航班搜索 -->
        <div class="search-box">
            <button class="search" @click="searchFlight">搜寻航班</button>
        </div>
    </div>

</template>

<script setup>
import { ref, watch } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const journeyType = ref('');
const departure = ref("");
const ticket = ref({
    destination: "",
    departureTime: "",
});
const disableReturn = ref(false);
const dateToString = (date) => {
    return new Date(date).toISOString().split('T')[0]
}
const searchFlight = () => {
    ticket.value.departureTime = dateToString(ticket.value.departureTime);
    router.push({
        path: '/flight',
        query: ticket.value
    })
}

watch(journeyType, (newValue) => {
    disableReturn.value = newValue === '单程';
});
</script>
<style>
.main-box {
    width: 100%;
    display: flex;
    justify-content: space-between;
}

.main-button {
    text-align: center;
    border: 0;
    border-radius: 0;
    background-color: #f6f6f2;
    width: 24%;
    height: 50px;
    color: #016b6c;
    font-size: 1em;
}

.main-button:focus{
    background-color: #016b6c;
    color: white;
}

.sub-box {
    border-top: 1px solid #e0e0e0;
    border-bottom: 1px solid #e0e0e0;
    width: 100%;
}

.sub-button {
    width: 100px;
    border: 0;
    background-color: white;
    border-top: 3px solid white;
    border-bottom: 3px solid white;
    margin-right: 50px;
    padding: 8px;
    font-size: 1em;
}

.sub-button:focus {
    color: #016b6c;
    border-bottom: 3px solid #016b6c;
}

.form-select,
.form-control {
    border: 0;
}

.col {
    margin: 1px;
    border-right: 1px solid #e0e0e0;
    border-bottom: 1px solid #e0e0e0;
}

.search-box {
    display: flex;
    justify-content: flex-end;
    border-bottom: 1px solid #e0e0e0;
    height: 50px;
}

.search {
    margin-right: 3px;
    margin-left: 3px;
    display: inline-block;
    padding: 12px 80px;
    border: 0;
    border-radius: 0px;
    transition: all 0.2s ease-in;
    position: relative;
    overflow: hidden;
    font-size: 1em;
    cursor: pointer;
    color: black;
    z-index: 1;
    color: #016b6c;
    background-color: #f6f6f2;
}

.search:before {
    content: "";
    position: absolute;
    left: 50%;
    transform: translateX(-50%) scaleY(1) scaleX(1.25);
    top: 100%;
    width: 140%;
    height: 180%;
    background-color: rgba(0, 0, 0, 0.05);
    border-radius: 50%;
    display: block;
    transition: all 0.5s 0.1s cubic-bezier(0.55, 0, 0.1, 1);
    z-index: -1;
}

.search:after {
    content: "";
    position: absolute;
    left: 55%;
    transform: translateX(-50%) scaleY(1) scaleX(1.45);
    top: 180%;
    width: 160%;
    height: 190%;
    background-color: #016b6c;
    border-radius: 50%;
    display: block;
    transition: all 0.5s 0.1s cubic-bezier(0.55, 0, 0.1, 1);
    z-index: -1;
}

.search:hover {
    color: #ffffff;
    border: 0;
}

.search:hover:before {
    top: -35%;
    background-color: #016b6c;
    transform: translateX(-50%) scaleY(1.3) scaleX(0.8);
}

.search:hover:after {
    top: -45%;
    background-color: #016b6c;
    transform: translateX(-50%) scaleY(1.3) scaleX(0.8);
}
</style>
