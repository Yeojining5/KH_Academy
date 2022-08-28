// 파이어베이스 공통코드
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.9.3/firebase-app.js";
const firebaseConfig = {
  apiKey: "AIzaSyA3bZ9ZqoBiM9vxH5iauLABVOZzK35MdQk",
  authDomain: "kh-terrgym2022.firebaseapp.com",
  databaseURL:
    "https://kh-terrgym2022-default-rtdb.asia-southeast1.firebasedatabase.app",
  projectId: "kh-terrgym2022",
  storageBucket: "kh-terrgym2022.appspot.com",
  messagingSenderId: "106312190597",
  appId: "1:106312190597:web:986b8107cb27801f74f7ec",
  measurementId: "G-5DV4JCJLPE",
};

export const firebaseApp = initializeApp(firebaseConfig);
console.log(firebaseApp);
