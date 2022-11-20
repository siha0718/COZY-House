<template>
    <div class="container-sm">
        <h1 class="underline mt-5">Abstract</h1>
        <div>
            <b-form class="absBtn">
                <b-form-group class="mt-5" id="input-group-1" label="No:" label-for="input-1" description="">
                    <b-form-input id="input-1" v-model="board.no" type="text" readonly>
                    </b-form-input>
                </b-form-group>

                <b-form-group id="input-group-2" label="Title:" label-for="input-2">
                    <b-form-input id="input-2" v-model="board.title" type="text" placeholder="글 제목" readonly required>
                    </b-form-input>
                </b-form-group>

                <b-form-group id="input-group-3" label="Writer:" label-for="input-3">
                    <b-form-input id="input-3" v-model="board.writer" placeholder="작성자" readonly required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-4" label="Contents:" label-for="input-4">
                    <b-form-textarea id="input-4" v-model="board.content" placeholder="내용..." readonly required>
                    </b-form-textarea>
                </b-form-group>
                <div style="padding-top: 15px">
                    <b-button :to="{ name: 'boardmodify', params: { no: board.no } }" pill >Modify</b-button>
                    <b-button @click="deleteBoard(board)" pill >Delete</b-button>
                    <b-button :to="{ name: 'boardlist' }" pill >List</b-button>
                </div>
            </b-form>
        </div>
    </div>
</template>
<script>
import http from "@/util/http-common";

export default {
    name: "BoardView",
    data() {
        return {
            board: {
                no: "",
                title: "",
                write: "",
                content: "",
            }
        };
    },

    created() {
        http({
            url: `/board/${this.$route.params.no}`,
            method: "get"
        }).then(({ data }) => {
            this.board = data;
        });
    },
    methods: {
        deleteBoard(board) {
            let check = confirm("정말 삭제하시겠습니까?");
            if (!check) return;
            // 파라미터 board를 "/board/board.no"로 method: delete 해줘서 data 받기 => return : success or fail  
            http({
                url: `/board/${board.no}`,
                method: "delete",
            }).then(({ data }) => {
                let msg = "글 삭제 중 에러 발생 !";

                if (data == "success") msg = "글 삭제 완료 !";
                alert(msg);
                this.$router.push(({ name: "boardlist" }));
            })
        },
    }
}
</script>

<style>

.absBtn label {
    text-align : left;
}
.absBtn a {
    color: #2c3034!important;

}

.absBtn {
    width:450px;
    margin:auto;
}

/* .board{
    padding-left: 50px;
} */
</style>