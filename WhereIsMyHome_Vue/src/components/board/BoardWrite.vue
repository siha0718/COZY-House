<template>
    <div>
        <h3 class="mt-5">New Contents</h3>
        <div>
            <b-form class="newContents mt-5">
                <b-form-group id="input-group-1" label="Title" label-for="input-1">
                    <b-form-input id="input-1" v-model="board.title" type="text" placeholder="글 제목" required>
                    </b-form-input>
                </b-form-group>

                <b-form-group  id="input-group-2" label="Writer:" label-for="input-2">
                    <b-form-input id="input-2" v-model="board.writer" placeholder="작성자" required></b-form-input>
                </b-form-group>

                <b-form-group id="input-group-3" label="Contents:" label-for="input-3">
                    <b-form-textarea id="input-3" v-model="board.content" placeholder="내용..." required>
                    </b-form-textarea>
                </b-form-group>
                <b-button @click="newPost" variant="primary">Create</b-button>
                <b-button type="reset" variant="danger">Cancel</b-button>
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
    name: "BoardWrite",
    data() {
        return {
            board: {
                title: "",
                writer: "",
                content: "",
            },
        }
    },
    components: {
    },
    methods: {
        newPost() {
            let board = {
                title: this.board.title,
                writer: this.board.writer,
                content: this.board.content,
            }

            http({
                url: "/board",
                method: "post",
                data: board,
            }).then(({ data }) => {
                let msg = "글 등록 중 문제 발생";

                if (data == 'success') msg = "글 등록 완료 !";
                alert(msg);
                this.$router.push(({ name: "board" }));
            });
        }
    }
}
</script>

<style>

h3{ 
    font-style: italic;
}

.newContents{
    width:450px;
    margin:auto;
}
</style>