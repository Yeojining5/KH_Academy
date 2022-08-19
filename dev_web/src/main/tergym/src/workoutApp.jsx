import React, { useState } from "react";
import Workouts from "./components/Workouts"
import "./app.css";

function WorkoutApp() {
  const [items, setItems] = useState([
    {id: 1, name: "벤치프레스", count: 0},
    {id: 2, name: "랫풀다운", count: 0},
    {id: 3, name: "스쿼트", count: 0},
  ]);

    const handleDecrement = (e) => {
      //setCount(count <=0 ? 0: count-1);
      //setName("랩풀다운");
      };
    
      const handleIncrement = (workout) => {
        console.log(`workout: ${workout.name}, ${workout.count}`);
        // 사용자가 선택한 로우의 인덱스 값을 알아낸다
        const index = items.indexOf(workout); // 0, 1, 2
        items[index].count += 1;
        //setItems([...items]);
      };

      const handleDelete = () => {
        
      };

  return ( 
  <Workouts workouts={items}  // 태그의 속성으로 값을 넘길 수 있다 - props 활용
  onIncrement={handleIncrement} />
  );
}

export default WorkoutApp;

// 결론적으로 부모태그에서 하위태그로는 항상 언제든지 props를 통해서 값을 전달할 수 있다.
// 다만 매번 파일마다 props를 전달해야 하므로 피로도가 높다 - 그래서 리덕스가 출현
// 이벤트 처리도 위임하거나 전달이 가능하다
// 자바스트립트에서는 함수도 객체 이니까.... 
// ajax가 없어도 리액트에서는 그런 효과를 처리가능함