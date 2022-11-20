// http에서 공통으로 사용하는 것들 관리
import axios from "axios";

// axios를 만들어서 외부에서 사용하겠다 ( export default )
export default axios.create({
    baseURL: "http://70.12.50.137:9999/api/", // /spring context root
    headers: {
        "Content-Type": "application/json",
    },
});