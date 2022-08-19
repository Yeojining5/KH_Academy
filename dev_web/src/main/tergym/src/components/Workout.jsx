import React, { useState } from "react";

function Workout(props) {
  console.log(props.workout.name + props.workout.count);
            
  // 바닐라스크립트에서 함수는 객체이다
  const handleDecrement = (e) => {
  //setCount(count <=0 ? 0: count-1);
  //setName("랩풀다운");
  };

  const handleIncrement = (e) => {
    console.log(e);
    //setCount(count+1);
    //setName("스쿼트");
  };

  const handleDelete = () => {

  };

  return (
    <>
      <li className="workout">
        <span className="workout-name">{props.workout.name}</span>
        <span className="workout-count">{props.workout.count}</span>
        <button className="wo-button workout-increase" onClick={handleIncrement}>
          <i className="fas fa-plus-square"></i>
        </button>
        <button className="wo-button workout-decrease" onClick={handleDecrement}>
          <i className="fas fa-minus-square"></i>
        </button>
        <button className="wo-button workout-delete" onClick={handleDelete}>
          <i className="fas fa-trash"></i>
        </button>
      </li>
    </>
  );
}

export default Workout;