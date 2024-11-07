<template>
    <div>
        <Nav />
        <main class="content">
            <div class="carousel-container">
                <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExample" data-bs-slide-to="0" class="active"
                            aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExample" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExample" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                    </div>

                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <a href="/info1">
                                <img src="../assets/homepage/images/info1.jpg" class="d-block w-100" alt="Image 1">
                            </a>
                        </div>
                        <div class="carousel-item">
                            <img src="../assets/homepage/images/info2.jpg" class="d-block w-100" alt="Image 2">
                        </div>
                        <div class="carousel-item">
                            <img src="../assets/homepage/images/info3.jpg" class="d-block w-100" alt="Image 3">
                        </div>
                    </div>
                </div>
            </div>
            <div class="book">
                <Book />
            </div>
        </main>
        <Foot />
    </div>

</template>

<script setup>
import Nav from '../components/Nav.vue';
import Book from '../components/Book.vue';
import Foot from '../components/Foot.vue';
</script>

<style scoped>
.book {
    position: relative;
    margin: 10px;
    /* transform: translate(0%, 0%); */
}

body {
    margin: 0;
    font-family: Arial, sans-serif;
}

.content {
    padding-top: 10vh;
    /* 留出头部空间 */
}

.carousel-container {
    position: relative;
    width: 100%;
    height: 300px;
    background-color: white;
    display: flex;
    align-items: center;
    justify-content: center;
    overflow: hidden;
}

.carousel-container .carousel-inner {
    position: relative;
    left: 0;
    width: 200vh;
}

.carousel-container .carousel-indicators {
    position: relative;
    top: 650px;
}

.carousel-container .carousel-indicators button {
    background-color: #fff;
    /* Customize the color */
    width: 100px;
    height: 5px;
    border: none;
}
</style>