// 파이어베이스 공통코드 
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.9.3/firebase-app.js";
const firebaseConfig = {
  apiKey: "AIzaSyCrA0QQH5QpbtWdyVbrQB72APSQxH3cjl4",
  authDomain: "semi-intelligym.firebaseapp.com",
  databaseURL: "https://semi-intelligym-default-rtdb.asia-southeast1.firebasedatabase.app",
  projectId: "semi-intelligym",
  storageBucket: "semi-intelligym.appspot.com",
  messagingSenderId: "925436106266",
};

export const firebaseApp = initializeApp(firebaseConfig);
console.log(firebaseApp);
