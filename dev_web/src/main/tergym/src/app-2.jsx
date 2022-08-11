import React from "react";
import './app.css';
import "bootstrap/dist/css/bootstrap.min.css"

function App() {
  return (
    <h1 
    className="title" 
    onClick={()=>{console.log('onClick Event')}}>
    Hello
    </h1>
  );
}

export default App;
