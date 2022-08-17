import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import WorkoutApp from './workoutApp';
import "@fortawesome/fontawesome-free/js/all.js"
//npm i @fortawesome/fontawesome-free

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <WorkoutApp />
  </React.StrictMode>
);
