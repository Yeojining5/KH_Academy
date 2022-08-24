import React from "react";
import Workout from "./Workout";

function Workouts(props) {
  console.log(props); //객체로 받는 경우
  console.log(props.workouts); //배열

  const handleIncrement = (workout) => {
    props.onIncrement(workout);
  };

  //바닐라스크립트에서 함수는 객체이다
  const handleDecrement = (workout) => {
    props.onDecrement(workout);
  };

  const handleDelete = (workout) => {
    props.onDelete(workout);
  };
  
  return (
    <div className="workouts">
      <ul>
        {props.workouts.map((workout) => (
          <Workout
            key={workout.id} //
            onIncrement={handleIncrement}
            onDecrement={handleDecrement}
            onDelete={handleDelete}
            workout={workout}
          />
        ))}
      </ul>
    </div>
  );
}

export default Workouts;
