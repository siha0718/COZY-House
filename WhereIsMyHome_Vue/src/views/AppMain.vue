<template>
  <main class="flex-shrink-0">
    <!-- Header-->
    <header class="bg-dark backimg py-5">
      <div class="container px-5">
        <div class="row gx-5 align-items-center justify-content-center">
          <div class="col-lg-8 col-xl-7 col-xxl-6 mainText">
            <div class="text-center text-xl-start">
              <div class="display-5">
                <p class="mb-2">당신이 찾는 집, <br /></p>
                <span>바로 여기서 찾아드리겠습니다.</span>
              </div>

              <div
                class="d-grid gap-3 d-sm-flex justify-content-sm-center justify-content-xl-start"
              >
                <a class="btn me-sm-3 mainBtn" href="#">아파트</a>
                <a class="btn mainBtn" href="#!">빌라</a>
                <a class="btn mainBtn" href="#!">원룸, 투룸</a>
                <a class="btn mainBtn" href="#!">오피스텔</a>
              </div>

              <div class="input-group mb-2">
                <input
                  class="form-control mainInput"
                  type="text"
                  placeholder="지역, 지하철역, 학교 검색"
                />
              </div>
            </div>
          </div>
          <div class="col-xl-5 col-xxl-6 d-none d-xl-block text-center"></div>
        </div>
      </div>
    </header>
    <!-- Features section-->

    <div class="row">
      <section class="py-5 col-8 leftSec" id="features">
        <div class="container px-5 my-5">
          <h4 class="recommTitle">추천 매물</h4>
          <p class="mb-5">당신의 라이프 스타일에 가장 좋습니다</p>
          <div class="gx-5">
            <div class="">
              <div class="row gx-5 row-cols-1 row-cols-md-2">
                <div class="col mb-5 h-100 recommBox">
                  <div
                    class="feature bg-primary bg-gradient text-white rounded-3 mb-3"
                  >
                    <i class="bi bi-collection"></i>
                  </div>
                  <div class="recommImg">
                    <img src="@/assets/2.jpg" width="100%" alt="" />
                  </div>
                  <ul class="mainList">
                    <li>투룸</li>
                    <li><strong>월세 2억/140</strong></li>
                    <li>51.24 2층</li>
                    <li>서울 역삼동</li>
                    <li>신축!!</li>
                  </ul>
                </div>
                <div class="col mb-5 h-100 recommBox">
                  <div
                    class="feature bg-primary bg-gradient text-white rounded-3 mb-3"
                  >
                    <i class="bi bi-collection"></i>
                  </div>
                  <div class="recommImg">
                    <img src="@/assets/2.jpg" width="100%" alt="" />
                  </div>
                  <ul class="mainList">
                    <li>투룸</li>
                    <li><strong>월세 2억/140</strong></li>
                    <li>51.24 2층</li>
                    <li>서울 역삼동</li>
                    <li>신축!!</li>
                  </ul>
                </div>
                <div class="col mb-5 h-100 recommBox">
                  <div
                    class="feature bg-primary bg-gradient text-white rounded-3 mb-3"
                  >
                    <i class="bi bi-collection"></i>
                  </div>
                  <div class="recommImg">
                    <img src="@/assets/2.jpg" width="100%" alt="" />
                  </div>
                  <ul class="mainList">
                    <li>투룸</li>
                    <li><strong>월세 2억/140</strong></li>
                    <li>51.24 2층</li>
                    <li>서울 역삼동</li>
                    <li>신축!!</li>
                  </ul>
                </div>
                <div class="col mb-5 h-100 recommBox">
                  <div
                    class="feature bg-primary bg-gradient text-white rounded-3 mb-3"
                  >
                    <i class="bi bi-collection"></i>
                  </div>
                  <div class="recommImg">
                    <img src="@/assets/2.jpg" width="100%" alt="" />
                  </div>
                  <ul class="mainList">
                    <li>투룸</li>
                    <li><strong>월세 2억/140</strong></li>
                    <li>51.24 2층</li>
                    <li>서울 역삼동</li>
                    <li>신축!!</li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <section class="col-4 py-5">
        <div class="container px-5 my-5">
          <h4 class="recommTitle liner pb-3">건의사항</h4>
          <div class="infoList">
            <ul>
              <li>
                <a href="#" class="info">[공지] ㅇㅇ 서비스 정상화 안내</a>
              </li>
              <li>
                <a href="#" class="info">[공지] ㅇㅇ 서비스 정상화 안내</a>
              </li>
              <li>
                <a href="#" class="info">[공지] ㅇㅇ 서비스 정상화 안내</a>
              </li>
              <li>
                <a href="#" class="info">[공지] ㅇㅇ 서비스 정상화 안내</a>
              </li>
              <li>
                <a href="#" class="info">[공지] ㅇㅇ 서비스 정상화 안내</a>
              </li>
              <li>
                <a href="#" class="info">[공지] ㅇㅇ 서비스 정상화 안내</a>
              </li>
              <li>
                <a href="#" class="info">[공지] ㅇㅇ 서비스 정상화 안내</a>
              </li>
              <li>
                <a href="#" class="info">[공지] ㅇㅇ 서비스 정상화 안내</a>
              </li>
            </ul>
          </div>
        </div>
      </section>
    </div>
  </main>
</template>

<script>
export default {};
</script>

<style scoped>
@import "../../public/css/main.css";
</style>
