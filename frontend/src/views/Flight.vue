<template>
    <Nav />
    <main class="content">
        <div v-if="isLoading">
            <h1>loading...</h1>
        </div>
        <div v-else>
            <div class="flow">
                <span v-if="step === 2 || step === 3">① 选择航班</span>
                <span v-if="step === 1" style="color: #2985ad;font-weight: bolder;">① 选择航班</span>
                <span v-if="step === 1 || step === 3">② 跨境交通</span>
                <span v-if="step === 2" style="color: #2985ad;font-weight: bolder;">② 跨境交通</span>
                <span v-if="step === 1 || step === 2">③ 确认付款</span>
                <span v-if="step === 3" style="color: #2985ad;font-weight: bolder;">③ 确认付款</span>
                <span style="position: relative;right: -700px;">香港 ---- {{ props.destination.substring(0, 2) }}</span>
            </div>

            <div v-if="step === 1">
                <div clas="card">
                    <span class="card-title">选择出发</span>
                    <div class="card-body">
                        <svg t="1730927829620" class="icon" viewBox="0 0 1024 1024" version="1.1"
                            xmlns="http://www.w3.org/2000/svg" p-id="7666" width="200" height="200">
                            <path
                                d="M778.6 436.8l-47.9-3.4-279.5-327.3C429.2 78 407.9 64 387.4 64h-38.7l177 378.3-245.6 18.2-96-107.4h-74.4l98.4 150.5-98.2 165.3h74.3l95.9-107.4 245.6 18.2-177 380.3h38.7c20.5 0 41.8-14.1 63.8-42.1l279.4-327.1 47.9-3.4c11.4-1.5 21.9-2.9 31.4-3.9 9.5-1.2 21.9-3.6 37-7.5 15.2-3.7 30.2-11.7 45-23.9s22.3-25.5 22.3-39.9c0.1-42.8-45.2-67.8-135.6-75.4z"
                                p-id="7667" fill="#016b6c"></path>
                        </svg>
                        <span> 香港 往 {{ props.destination }} &nbsp;{{ (props.departureTime).split('-')[0] }}年{{
                            (props.departureTime).split('-')[1] }}月{{ (props.departureTime).split('-')[2] }}日</span>
                    </div>
                </div>
                <div class="header-box">
                    <span>排列方式：推荐</span> <a href="#">出发时间</a> <a href="#">抵达时间</a> <a href="#">航行时间</a> <a
                        href="#">票价</a>
                    <div style="margin-top: 10px;">
                        <span>找到{{ flightInfo.length }}个结果</span>
                    </div>
                </div>
                <div class="card" v-for="flight in flightInfo" :key="flight.flightNumber">
                    <div class="card-body">
                        <div class="row" id="step1">
                            <div class="col">
                                <div>
                                    <span style="font-weight: bolder;">{{ (flight.departureTime).split(',')[1]
                                        }}</span><br>
                                    <span style="color: black; font-weight: bolder;">{{ flight.departureCode }}</span>
                                </div>
                            </div>
                            <div class="col">
                                <div>
                                    <svg t="1730927829620" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                        xmlns="http://www.w3.org/2000/svg" p-id="7666" width="200" height="200">
                                        <path
                                            d="M778.6 436.8l-47.9-3.4-279.5-327.3C429.2 78 407.9 64 387.4 64h-38.7l177 378.3-245.6 18.2-96-107.4h-74.4l98.4 150.5-98.2 165.3h74.3l95.9-107.4 245.6 18.2-177 380.3h38.7c20.5 0 41.8-14.1 63.8-42.1l279.4-327.1 47.9-3.4c11.4-1.5 21.9-2.9 31.4-3.9 9.5-1.2 21.9-3.6 37-7.5 15.2-3.7 30.2-11.7 45-23.9s22.3-25.5 22.3-39.9c0.1-42.8-45.2-67.8-135.6-75.4z"
                                            p-id="7667" fill="#016b6c"></path>
                                    </svg>
                                    <span> 耗时 {{ flight.flightDuration }}m</span>
                                </div>
                            </div>
                            <div class="col">
                                <div>
                                    <span style="font-weight: bolder;">{{ (flight.destinationTime).split(',')[1]
                                        }}</span><br>
                                    <span style="color: black; font-weight: bolder;">{{ flight.destinationCode }}</span>
                                </div>
                            </div>
                            <div class="col">
                                <div>
                                    <span style="color: black;">{{ flight.flightNumber }}</span>
                                </div>
                            </div>
                            <div class="col">
                                <div @click="selectFlight(flight)">
                                    <span style="color: #2985ad;font-weight: bolder;">RMB {{ flight.price }} 起</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div v-if="step === 2">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <div>
                                    <span style="font-weight: bolder;">{{ (selectedFlight.departureTime).split(',')[1]
                                        }}</span><br>
                                    <span style="color: black; font-weight: bolder;">{{ selectedFlight.departureCode
                                        }}</span>
                                </div>
                            </div>

                            <div class="col">
                                <div>
                                    <svg t="1730927829620" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                        xmlns="http://www.w3.org/2000/svg" p-id="7666" width="200" height="200">
                                        <path
                                            d="M778.6 436.8l-47.9-3.4-279.5-327.3C429.2 78 407.9 64 387.4 64h-38.7l177 378.3-245.6 18.2-96-107.4h-74.4l98.4 150.5-98.2 165.3h74.3l95.9-107.4 245.6 18.2-177 380.3h38.7c20.5 0 41.8-14.1 63.8-42.1l279.4-327.1 47.9-3.4c11.4-1.5 21.9-2.9 31.4-3.9 9.5-1.2 21.9-3.6 37-7.5 15.2-3.7 30.2-11.7 45-23.9s22.3-25.5 22.3-39.9c0.1-42.8-45.2-67.8-135.6-75.4z"
                                            p-id="7667" fill="#016b6c"></path>
                                    </svg>
                                    <span> 耗时 {{ selectedFlight.flightDuration }}m</span>
                                </div>
                            </div>
                            <div class="col">
                                <div>
                                    <span style="font-weight: bolder;">{{ (selectedFlight.destinationTime).split(',')[1]
                                        }}</span><br>
                                    <span style="color: black; font-weight: bolder;">{{ selectedFlight.destinationCode
                                        }}</span>
                                </div>
                            </div>
                            <div class="col">
                                <div>
                                    <span style="color: black;">{{ selectedFlight.flightNumber }}</span>
                                </div>
                            </div>
                            <div class="col">
                                <div
                                    style="background-color: #e0e0e0;padding: 10px;width: 150px;border-left: 3px solid #016b6c;">
                                    <span>经济</span> <span>RMB {{ selectedFlight.price }}</span>
                                </div>
                            </div>
                            <div class="col">
                                <button @click="step = 1"
                                    style="border: 2px solid #016b6c;padding: 9px;width: 150px;background-color: white;color: #016b6c">选择其他航班</button>
                            </div>
                            <div class="col">
                                <button @click="goToPayment"
                                    style="border: 0;background-color: #016b6c;padding: 10px;color: white;width: 150px;">组合订购</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="header-box">
                    <span>排列方式：推荐</span> <a href="#">出发时间</a> <a href="#">抵达时间</a> <a href="#">航行时间</a> <a
                        href="#">票价</a>
                </div>

                <div class="card" @click="calcTotalAmount(ferry)" :style="highlight(ferry.planId)"
                    v-for="(ferry, index) in ferryInfo" :key="index" v-show="index === 0 || !callapsed">
                    <div class="row">
                        <div class="col">
                            <span v-show="index === 0" class="trans">轮渡</span>

                        </div>
                        <div class="col">
                            <div>
                                <span v-show="index === 0">{{ (ferry.departureTime).split(',')[0].split('-')[0] }} 年 {{
                                    (ferry.departureTime).split(',')[0].split('-')[1] }} 月 {{
                                        (ferry.departureTime).split(',')[0].split('-')[2] }} 日</span><br>
                                <span>{{ (ferry.departureTime).split(',')[1] }}</span><br>
                                <span v-show="index === 0">{{ ferry.departureCode }}</span><br>
<!--                                <span v-show="index === 0">{{ ferry.departurePort }}</span>-->
                              <select v-show="index === 0">
                                <option selected :value="ferry.departurePort">{{ ferry.departurePort }}</option>
                                <option value="深圳湾机场码头">深圳湾机场码头</option>
                              </select>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <svg t="1730944287538" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                    xmlns="http://www.w3.org/2000/svg" p-id="4438" width="200" height="200">
                                    <path
                                        d="M989.866667 904.533333c-47.786667 0-68.266667 20.48-92.16 37.546667-20.48 17.066667-34.133333 30.72-68.266667 30.72s-51.2-13.653333-68.266667-30.72c-20.48-17.066667-44.373333-37.546667-92.16-37.546667-47.786667 0-68.266667 20.48-92.16 37.546667-20.48 17.066667-34.133333 30.72-68.266666 30.72s-51.2-13.653333-68.266667-30.72c-20.48-17.066667-44.373333-37.546667-92.16-37.546667s-68.266667 20.48-92.16 37.546667c-20.48 17.066667-34.133333 30.72-68.266667 30.72s-51.2-13.653333-68.266666-30.72-37.546667-37.546667-85.333334-37.546667c-10.24 0-17.066667 6.826667-17.066666 17.066667s6.826667 17.066667 17.066666 17.066667c34.133333 0 51.2 13.653333 68.266667 30.72 20.48 17.066667 44.373333 37.546667 92.16 37.546666 47.786667 0 68.266667-20.48 92.16-37.546666 20.48-17.066667 34.133333-30.72 68.266667-30.72s51.2 13.653333 68.266666 30.72c20.48 17.066667 44.373333 37.546667 92.16 37.546666s68.266667-20.48 92.16-37.546666c20.48-17.066667 34.133333-30.72 68.266667-30.72s51.2 13.653333 68.266667 30.72c20.48 17.066667 44.373333 37.546667 92.16 37.546666 47.786667 0 68.266667-20.48 92.16-37.546666 20.48-17.066667 34.133333-30.72 68.266666-30.72 10.24 0 17.066667-6.826667 17.066667-17.066667s-13.653333-17.066667-23.893333-17.066667zM34.133333 836.266667c34.133333 0 51.2 13.653333 68.266667 30.72 20.48 17.066667 44.373333 37.546667 92.16 37.546666 47.786667 0 68.266667-20.48 92.16-37.546666 20.48-17.066667 34.133333-30.72 68.266667-30.72s51.2 13.653333 68.266666 30.72c20.48 17.066667 44.373333 37.546667 92.16 37.546666 47.786667 0 68.266667-20.48 92.16-37.546666 20.48-17.066667 34.133333-30.72 68.266667-30.72s51.2 13.653333 68.266667 30.72c20.48 17.066667 44.373333 37.546667 92.16 37.546666 47.786667 0 68.266667-20.48 92.16-37.546666 20.48-17.066667 34.133333-30.72 68.266666-30.72 10.24 0 17.066667-6.826667 17.066667-17.066667s-6.826667-17.066667-17.066667-17.066667c-47.786667 0-68.266667 20.48-92.16 37.546667-20.48 17.066667-34.133333 30.72-68.266666 30.72-20.48 0-34.133333-6.826667-47.786667-13.653333l153.6-372.053334c3.413333-3.413333 3.413333-10.24 0-13.653333l-10.24-10.24-409.6-102.4H512l-375.466667 102.4c-3.413333 0-6.826667 3.413333-10.24 6.826667-3.413333 3.413333-3.413333 10.24 0 13.653333L242.346667 853.333333c-13.653333 10.24-27.306667 17.066667-51.2 17.066667-34.133333 0-51.2-13.653333-68.266667-30.72-20.48-17.066667-44.373333-37.546667-88.746667-37.546667-10.24 0-17.066667 6.826667-17.066666 17.066667s6.826667 17.066667 17.066666 17.066667z m477.866667-375.466667c10.24 0 17.066667 6.826667 17.066667 17.066667v389.12c-6.826667 0-10.24 3.413333-17.066667 3.413333s-10.24 0-17.066667-3.413333V477.866667c0-10.24 6.826667-17.066667 17.066667-17.066667z"
                                        fill="#016b6c" p-id="4439"></path>
                                    <path
                                        d="M174.08 413.013333l324.266667-88.746666c6.826667-3.413333 17.066667-3.413333 27.306666 0l358.4 88.746666h3.413334c3.413333 0 6.826667 0 10.24-3.413333 3.413333-3.413333 6.826667-6.826667 6.826666-13.653333V204.8c0-10.24-6.826667-17.066667-17.066666-17.066667s-17.066667 6.826667-17.066667 17.066667v81.92l-34.133333-6.826667V170.666667c0-10.24-6.826667-17.066667-13.653334-17.066667l-88.746666-10.24V34.133333c0-10.24-6.826667-17.066667-17.066667-17.066666s-17.066667 6.826667-17.066667 17.066666v105.813334l-184.32-20.48H512l-150.186667 20.48V34.133333c0-10.24-6.826667-17.066667-17.066666-17.066666s-20.48 6.826667-20.48 17.066666v109.226667l-88.746667 10.24c-6.826667 0-13.653333 6.826667-13.653333 17.066667v109.226666l-34.133334 6.826667V204.8c0-10.24-6.826667-17.066667-17.066666-17.066667s-17.066667 6.826667-17.066667 17.066667v194.56c0 6.826667 3.413333 10.24 6.826667 13.653333 3.413333 0 10.24 3.413333 13.653333 0z m696.32-54.613333c-3.413333 6.826667-10.24 13.653333-17.066667 13.653333h-3.413333l-286.72-71.68c-10.24-3.413333-13.653333-10.24-13.653333-20.48 3.413333-10.24 10.24-13.653333 20.48-13.653333l286.72 71.68c10.24 3.413333 17.066667 13.653333 13.653333 20.48z m-614.4-174.08l256-30.72 290.133333 30.72V273.066667l-286.72-51.2h-6.826666L256 273.066667V184.32zM201.386667 337.92l245.76-68.266667c10.24-3.413333 17.066667 3.413333 20.48 13.653334s-3.413333 17.066667-13.653334 20.48l-245.76 68.266666H204.8c-6.826667 0-13.653333-3.413333-17.066667-13.653333-3.413333-10.24 3.413333-20.48 13.653334-20.48z"
                                        fill="#016b6c" p-id="4440"></path>
                                </svg>
                                <span class="dur">{{ ferry.duration }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span v-show="index === 0">{{ (ferry.arrivalTime).split(',')[0].split('-')[0] }} 年 {{
                                    (ferry.arrivalTime).split(',')[0].split('-')[1] }} 月 {{
                                        (ferry.arrivalTime).split(',')[0].split('-')[2] }} 日</span><br>
                                <span>{{ (ferry.arrivalTime).split(',')[1] }}</span><br>
                                <span v-show="index === 0">{{ ferry.destinationCode }}</span><br>
                                <span v-show="index === 0">{{ ferry.arrivalPort }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>{{ ferry.planId }}</span><br>
                                <a v-show="index === 0" @click="callapsed = !callapsed">{{ callapsed ? '选择其他班次' : '收起'
                                    }}</a>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span v-show="index === 0">特惠价格</span><br>
                                <span>RMB{{ ferry.discountedPrice }}</span><br>
                                <span v-show="index === 0">RMB<del>{{ ferry.originalPrice }}</del></span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span v-show="index === 0">一票通价格</span><br>
                                <span>RMB{{ ferry.discountedPrice + selectedFlight.price }}</span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card" @click="calcTotalAmount(trainInfo)" :style="highlight(trainInfo.planId)">
                    <div class="row">
                        <div class="col">
                            <span class="trans">高铁</span>
                        </div>
                        <div class="col">
                            <div>
                                <span>{{ (trainInfo.departureTime).split(',')[0].split('-')[0] }} 年 {{
                                    (trainInfo.departureTime).split(',')[0].split('-')[1] }} 月 {{
                                        (trainInfo.departureTime).split(',')[0].split('-')[2] }} 日</span><br>
                                <span>{{ (trainInfo.departureTime).split(',')[1] }}</span><br>
                                <span>{{ trainInfo.departureCode }}</span><br>
                                <span>{{ trainInfo.departurePort }}</span>
                            </div>
                        </div>
                        <div class="col">

                            <div>
                                <svg t="1730944400545" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                    xmlns="http://www.w3.org/2000/svg" p-id="5756" width="200" height="200">
                                    <path
                                        d="M967.111111 691.2V535.893333c-136.931556 12.231111-262.485333 21.333333-262.485333 21.333334-5.745778-42.609778 5.688889-130.844444 5.688889-130.844445 88.462222 15.246222 176.924444 27.363556 256.796444 33.507556V316.871111c-131.185778-51.655111-219.648-115.541333-219.648-115.541333C618.951111 91.704889 470.641778 116.053333 470.641778 116.053333a267.776 267.776 0 0 0-165.546667 66.901334C245.191111 240.810667 188.074667 316.871111 139.662222 389.916444 82.488889 475.136 56.888889 569.514667 108.202667 669.809778c17.180444 33.564444 37.148444 60.871111 59.960889 88.291555 5.688889 6.087111 22.812444 33.564444 31.402666 33.564445A1508.124444 1508.124444 0 0 0 56.888889 885.873778h111.274667s74.183111-51.768889 145.521777-91.249778c48.583111 0 102.741333 2.958222 151.267556 2.958222-31.402667 21.390222-99.896889 69.973333-151.267556 112.583111H424.96s208.440889-143.018667 382.407111-176.469333l-17.066667 3.072A6745.884444 6745.884444 0 0 1 967.111111 691.2zM193.820444 535.893333c-39.992889 0-68.437333-18.204444-68.437333-42.552889s31.345778-42.609778 68.437333-42.609777c39.992889 0 68.494222 18.261333 68.494223 42.666666 2.844444 24.291556-28.444444 42.496-68.494223 42.496z m199.736889-225.109333l-142.620444-9.102222s62.748444-88.291556 82.773333-94.435556L419.271111 210.488889l-25.6 100.408889z m62.862223-97.393778l122.652444 3.015111V316.871111l-145.521778-6.030222 22.869334-97.393778z m65.592888 322.56c-39.992889 0-68.437333-18.204444-68.437333-42.609778 0-24.348444 31.288889-42.609778 68.437333-42.609777 39.936 0 68.494222 18.261333 68.494223 42.666666 0 24.291556-31.402667 42.496-68.494223 42.496z"
                                        fill="#016b6c" p-id="5757"></path>
                                </svg>
                                <span class="dur">{{ trainInfo.duration }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>{{ (trainInfo.arrivalTime).split(',')[0].split('-')[0] }} 年 {{
                                    (trainInfo.arrivalTime).split(',')[0].split('-')[1] }} 月 {{
                                        (trainInfo.arrivalTime).split(',')[0].split('-')[2] }} 日</span><br>
                                <span>{{ (trainInfo.arrivalTime).split(',')[1] }}</span><br>
                                <span>{{ trainInfo.destinationCode }}</span><br>
                                <span>{{ trainInfo.arrivalPort }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span class="dur">{{ trainInfo.planId }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>二等座</span><br>
                                <span>RMB{{ trainInfo.discountedPrice }}</span><br>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>一票通价格</span><br>
                                <span>RMB{{ trainInfo.discountedPrice + selectedFlight.price }}</span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card" @click="calcTotalAmount(busInfo)" :style="highlight(busInfo.planId)">
                    <div class="row">
                        <div class="col">
                            <span class="trans">巴士</span>
                        </div>
                        <div class="col">
                            <div>
                                <span>{{ (busInfo.departureTime).split(',')[0].split('-')[0] }} 年 {{
                                    (busInfo.departureTime).split(',')[0].split('-')[1] }} 月 {{
                                        (busInfo.departureTime).split(',')[0].split('-')[2] }} 日</span><br>
                                <span>{{ (busInfo.departureTime).split(',')[1] }}</span><br>
                                <span>{{ busInfo.departureCode }}</span><br>
                                <span>{{ busInfo.departurePort }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <svg t="1730944472246" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                    xmlns="http://www.w3.org/2000/svg" p-id="7178" width="200" height="200">
                                    <path
                                        d="M217.88090469 727.44010046m-105.3384285 0a105.3384285 105.3384285 0 1 0 210.676857 0 105.3384285 105.3384285 0 1 0-210.676857 0Z"
                                        fill="#016b6c" p-id="7179"></path>
                                    <path
                                        d="M876.54197729 233.8881377H87.09555246c-42.60880254 0-77.52434906 34.3237576-77.52434908 77.52434907v409.51793553c0 17.75366773 14.7947231 32.54839083 32.54839083 32.54839082h39.058069c-1.77536678-8.28504494-2.3671557-17.16187881-2.3671557-25.44692374 0-76.93256014 62.13783703-139.07039718 139.07039718-139.07039718s139.07039718 62.13783703 139.07039718 139.07039718c0 8.87683386-0.59178892 17.16187881-2.3671557 25.44692374h317.79065228c-1.77536678-8.28504494-2.3671557-17.16187881-2.3671557-25.44692374 0-76.93256014 62.13783703-139.07039718 139.07039717-139.07039718s139.07039718 62.13783703 139.07039719 139.07039718c0 8.87683386-0.59178892 17.16187881-2.3671557 25.44692374h35.50733545c18.93724557 0 34.3237576-15.38651203 34.3237576-34.3237576V372.36674595c-0.59178892-76.93256014-62.13783703-138.47860825-139.07039717-138.47860825zM224.98237178 422.66880452c0 4.7343114-4.14252246 8.87683386-8.87683386 8.87683386H70.52546257c-4.7343114 0-8.87683386-4.14252246-8.87683386-8.87683386V310.82069785c0-14.20293418 11.24398956-25.44692373 25.44692375-25.44692374h129.60177438c4.7343114 0 8.87683386 4.14252246 8.87683387 8.87683386v128.41819655z m69.83109306 8.28504492c-5.32610032 0-9.46862278-4.14252246-9.46862279-9.46862278V294.8423969c0-5.32610032 4.14252246-9.46862278 9.46862279-9.46862279h152.68154243c5.32610032 0 9.46862278 4.14252246 9.46862278 9.46862279v127.23461869c0 5.32610032-4.14252246 9.46862278-9.46862278 9.46862279H294.81346484z m312.46455195 226.06336905H416.72198321c-9.46862278 0-16.57008987-7.69325602-16.57008988-16.57008989s7.69325602-16.57008987 16.57008988-16.57008987h190.55603358c9.46862278 0 16.57008987 7.69325602 16.57008988 16.57008987s-7.10146709 16.57008987-16.57008988 16.57008989z m68.6475152-233.16483613c0 4.14252246-3.55073354 7.69325602-7.69325601 7.69325602h-142.62113073c-5.32610032 0-9.46862278-4.14252246-9.46862279-9.46862279V294.8423969c0-5.32610032 4.14252246-9.46862278 9.46862279-9.46862279h140.84576396c5.32610032 0 9.46862278 4.14252246 9.46862278 9.46862279v129.00998546z m287.01762822 37.28270222c0 8.87683386-7.10146709 16.57008987-16.57008988 16.57008988h-160.37479844c-27.81407944 0-50.30205855-22.48797912-50.30205856-50.30205856V300.16849722c0-8.28504494 6.50967817-14.20293418 14.20293418-14.20293419h125.45925193c47.93490286 0 86.40118293 38.46628008 86.40118292 86.40118292v88.76833863z"
                                        fill="#016b6c" p-id="7180"></path>
                                    <path
                                        d="M809.07803992 727.44010046m-105.33842849 0a105.3384285 105.3384285 0 1 0 210.676857 0 105.3384285 105.3384285 0 1 0-210.676857 0Z"
                                        fill="#016b6c" p-id="7181"></path>
                                </svg>
                                <span class="dur">{{ busInfo.duration }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>{{ (busInfo.arrivalTime).split(',')[0].split('-')[0] }} 年 {{
                                    (busInfo.arrivalTime).split(',')[0].split('-')[1] }} 月 {{
                                        (busInfo.arrivalTime).split(',')[0].split('-')[2] }} 日</span><br>
                                <span>{{ (busInfo.arrivalTime).split(',')[1] }}</span><br>
                                <span>{{ busInfo.destinationCode }}</span><br>
                                <span>{{ busInfo.arrivalPort }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>{{ busInfo.planId }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>特惠价格</span><br>
                                <span>RMB{{ busInfo.discountedPrice }}</span><br>
                                <span>RMB<del>{{ busInfo.originalPrice }}</del></span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>一票通价格</span><br>
                                <span>RMB{{ busInfo.discountedPrice + selectedFlight.price }}</span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card" @click="calcTotalAmount(limoInfo)" :style="highlight(limoInfo.planId)">
                    <div class="row">
                        <div class="col">
                            <span class="trans">专车</span>
                        </div>
                        <div class="col">
                            <div>
                                <span>{{ (limoInfo.departureTime).split(',')[0].split('-')[0] }} 年 {{
                                    (limoInfo.departureTime).split(',')[0].split('-')[1] }} 月 {{
                                        (limoInfo.departureTime).split(',')[0].split('-')[2] }} 日</span><br>
                                <span>{{ (limoInfo.departureTime).split(',')[1] }}</span><br>
                                <span>{{ limoInfo.departureCode }}</span><br>
                                <span>{{ limoInfo.departurePort }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <svg t="1730944535190" class="icon" viewBox="0 0 1024 1024" version="1.1"
                                    xmlns="http://www.w3.org/2000/svg" p-id="8483" width="200" height="200">
                                    <path
                                        d="M895.2832 399.93344h-79.03232c-3.60448 0.06144-7.168 1.024-10.30144 2.7648l-35.61472-107.08992c-11.3664-60.88704-54.35392-90.3168-107.13088-90.3168H328.4992c-60.6208 0-97.40288 39.44448-107.15136 90.25536l-35.71712 107.43808a21.97504 21.97504 0 0 0-10.93632-3.09248H95.68256a21.97504 21.97504 0 0 0-22.016 21.95456v19.0464c0 12.10368 9.85088 21.97504 22.016 21.97504l29.9008 5.12a137.56416 137.56416 0 0 0-14.80704 64.06144l-11.07968 126.3616c0 3.64544 0.26624 7.3728 0.7168 11.14112a42.1888 42.1888 0 0 0-0.7168 7.168v152.02304c0 21.64736 17.57184 39.15776 39.26016 39.15776H198.8608a39.19872 39.19872 0 0 0 39.28064-39.15776v-48.82432h515.39968v48.82432c0 21.64736 17.57184 39.15776 39.26016 39.15776h59.94496a39.19872 39.19872 0 0 0 39.26016-39.15776v-152.04352c0-2.39616-0.26624-4.79232-0.73728-7.14752 0.45056-3.76832 0.73728-7.49568 0.73728-11.1616l-11.10016-126.3616c0-24.59648-5.40672-45.6704-14.86848-64.14336l29.22496-4.95616a21.97504 21.97504 0 0 0 22.03648-21.97504v-19.0464a22.07744 22.07744 0 0 0-22.03648-21.97504z m-647.55712-22.46656l26.15296-69.46816 0.32768-1.6384c2.60096-14.00832 8.3968-16.54784 16.9984-27.36128h409.55904c8.68352 11.14112 14.09024 13.96736 16.44544 27.25888l26.60352 71.2704 9.74848 38.7072c-2.21184 28.32384-36.352 50.688-64.67584 50.688H302.65344c-28.38528 0-62.52544-22.36416-64.7168-50.70848l9.78944-38.74816z m18.30912 330.38336a59.392 59.392 0 1 1 5.18144-118.62016 59.392 59.392 0 0 1-5.18144 118.62016z m332.20608-43.76576a17.69472 17.69472 0 0 1-17.69472 17.63328H413.696a17.69472 17.69472 0 0 1-17.69472-17.6128v-49.58208c0-9.74848 7.94624-17.63328 17.69472-17.63328h166.85056c9.74848 0 17.69472 7.8848 17.69472 17.6128v49.58208z m127.26272 43.76576a59.392 59.392 0 0 1-59.4944-59.31008 59.392 59.392 0 0 1 59.4944-59.31008 59.392 59.392 0 0 1 59.47392 59.31008 59.43296 59.43296 0 0 1-59.47392 59.31008z"
                                        fill="#016b6c" p-id="8484"></path>
                                </svg>
                                <span class="dur">{{ limoInfo.duration }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>{{ (limoInfo.arrivalTime).split(',')[0].split('-')[0] }} 年 {{
                                    (limoInfo.arrivalTime).split(',')[0].split('-')[1] }} 月 {{
                                        (limoInfo.arrivalTime).split(',')[0].split('-')[2] }} 日</span><br>
                                <span>{{ (limoInfo.arrivalTime).split(',')[1] }}</span><br>
                                <span>{{ limoInfo.destinationCode }}</span><br>
                                <span>{{ limoInfo.arrivalPort }}</span>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>{{ limoInfo.planId }}</span><br>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>预估价格</span><br>
                                <span>RMB{{ limoInfo.discountedPrice }}</span><br>
                            </div>
                        </div>
                        <div class="col">
                            <div>
                                <span>一票通价格</span><br>
                                <span>RMB{{ limoInfo.discountedPrice + selectedFlight.price }}</span>
                            </div>
                        </div>
                    </div>
                </div>


            </div>

            <div v-if="step === 3">
                <Payment :amount="totalAmount" />
            </div>
        </div>
    </main>

</template>

<script setup>
import { onMounted } from 'vue';
import { requestGet } from '@/request/axios';
import { ref } from 'vue';
import Payment from '../components/Payment.vue';
import Nav from '../components/Nav.vue';

const props = defineProps(['destination', 'departureTime']);
const flightInfo = ref([]);
const isLoading = ref(true);
const step = ref(1);
const selectedFlight = ref(null);
const totalAmount = ref(0);
onMounted(async () => {
    await searchFlight()
})
async function searchFlight() {
    isLoading.value = true;
    flightInfo.value = await requestGet({ url: "/api/getFlightInfo?" + "destination=" + props.destination + "&departureTime=" + props.departureTime })
    isLoading.value = false;
}
const ferryInfo = ref([]);
const trainInfo = ref();
const busInfo = ref();
const limoInfo = ref();
const selectFlight = async (flight) => {
    isLoading.value = true;
    selectedFlight.value = flight;
    step.value = 2;
    ferryInfo.value = await requestGet({ url: "/api/getFerryTicket?" + "departureTime=" + props.departureTime + "," + selectedFlight.value.departureTime })
    trainInfo.value = await requestGet({url: "/api/getRailwayTicket"})
    busInfo.value = await requestGet({url: "/api/getBusTicket"})
    limoInfo.value = await requestGet({url: "/api/getLimoTicket"})
    isLoading.value = false;
}
const calcTotalAmount = (transport) => {
    totalAmount.value = transport.discountedPrice + selectedFlight.value.price;
    highlightPlanId.value = transport.planId;
}
const highlightPlanId = ref()
const highlight = (planId) => {
    if (highlightPlanId.value === planId) {
        return {
            backgroundColor: '#f6f6f2',
        }
    }
}

const goToPayment = () => {
    if (totalAmount.value > 0) {
        step.value = 3;
    }
}

const callapsed = ref(true);

</script>

<style scoped>
.trans {
    position: relative;
    transform: translate(50%, -50%);
    left: 30%;
    top: 25%;
    font-size: 2em;
}

.dur{
    color: black;
}

.flow {
    padding: 10px;
    border-bottom: 1px solid #e0e0e0;
}

.flow span {
    margin: 40px;
}

.content {
    padding-top: 10vh;
    /* 留出头部空间 */
}

.card-title {
    color: #016b6c;
    font-size: 1.5em;
    padding-left: 10px;
}

.header-box {
    background-color: #f6f6f2;
    padding: 10px;
}

.header-box a {
    margin-left: 50px;
}

svg {
    height: 15px;
    width: 15px;
}

a {
    color: #2985ad;
    text-decoration: none;
}

.col {
    border: 0;
    color: #016b6c;
}
</style>