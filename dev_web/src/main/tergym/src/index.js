import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import BootStrapApp from "./bootStrapApp";
import WorkoutApp from "./workoutApp";
import App from "./app";
import "@fortawesome/fontawesome-free/js/all.js";
import Bootstrap from "bootstrap";
import { BrowserRouter } from "react-router-dom";
//npm i @fortawesome/fontawesome-free

const root = ReactDOM.createRoot(document.getElementById("root5"));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <BootStrapApp />
    </BrowserRouter>
    {/* <WorkoutApp /> */}
    {/* <App /> */}
  </React.StrictMode>
);
