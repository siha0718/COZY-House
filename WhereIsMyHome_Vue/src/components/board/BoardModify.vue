<template>
    <!-- <div id="update">
        <h3>수정폼</h3>
        글번호 :<input type="text" v-model="board.no" readonly><br>
        제목 :<input type="text" v-model="board.title"><br>
        작성자 :<input type="text" v-model="board.writer" readonly><br>
        내용: <textarea cols="30" rows="10" v-model="board.content"></textarea>
        <button @click="modifyBoard(board)">수정</button>
    </div> -->
    <div>
        <h1 class="underline mt-5">Modify</h1>
        <div class="absbtn mt-5">
            <b-form>
                <b-form-group id="input-group-1" label="No:" label-for="input-1" description="">
                    <b-form-input id="input-1" v-model="board.no" type="text" readonly>
                    </b-form-input>
                </b-form-group>

                <b-form-group id="input-group-2" label="Title:" label-for="input-2" description="수정하실 글의 제목을 입력해주세요.">
                    <b-form-input id="input-2" v-model="board.title" type="text" placeholder="글 제목" required>
                    </b-form-input>
                </b-form-group>

                <b-form-group id="input-group-3" label="Writer:" label-for="input-3">
                    <b-form-input id="input-3" v-model="board.writer" placeholder="작성자" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Contents:" label-for="input-4">
                    <b-form-textarea id="input-4" v-model="board.content" placeholder="내용..." required>
                    </b-form-textarea>
                </b-form-group>
                <div style="padding-top: 15px">
                    <b-button @click="modifyBoard(board)">Modify</b-button>
                    <b-button :to="{ name: 'boardview', params: {no: board.no} }" variant="danger">Cancel</b-button>
                </div>
            </b-form>
            <!-- <b-card class="mt-3" header="Form Data Result">
                <pre class="m-0">{{ board }}</pre>
            </b-card> -->
        </div>
    </div>
</template>

<script>
import http from "@/util/http-common";

export default {
    name: "boardmodify",
    created() {
        http({
            url: `/board/${this.$route.params.no}`,
            method: "get"
        }).then(({ data }) => {
            this.board = data;
        })
    },
    data() {
        return {
            board: {
                no: "",
                title: "",
                writer: "",
                content: "",
            }
        };
    },
    methods: {
        modifyBoard(board) {
            // 파라미터 board를 "/board/board.no"로 method: put 해줘서 data 받기 => return : success or fail
            http({
                url: `/board/${board.no}`,
                method: "put",
                data: board
            }).then(({ data }) => {
                let check = confirm("해당 정보로 수정하시겠습니까?");
                if(!check) return;
                
                let msg = "글 수정 중 에러 발생 !";

                if (data == "success") msg = "글 수정 완료 !";
                alert(msg);
                this.$router.push(({ name: "boardview", params: board.no }));
            })

        },
    }
}
</script>

<style>
.absbtn {
    width:450px;
    margin:auto;
}
</style>