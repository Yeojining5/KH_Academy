import React from 'react';
import Workout from "./components/Workout"
import "./app.css";

function WorkoutApp() {
  const [item, setItems] = useState([
    {id: 1, name: "벤치프레스", count: 0},
    {id: 2, name: "스쿼트", count: 0},
    {id: 3, name: "레그프레스", count: 0},
  ])

  return <Workout />;
}

export default WorkoutApp;