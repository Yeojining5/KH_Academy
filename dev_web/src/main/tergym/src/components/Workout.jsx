import React, {useState} from 'react';

function Workout(props) {
  const [name, setName] = useState("레그프레스");
  const [count, setCount] = useState(3);

  // 상태를 관리해 본다
  const state = {
                  count: 0,
                };
                
  // 바닐라스크립트에서 함수는 객체이다
  const handleDecrement = (e) => {
  setCount(count <=0 ? 0: count-1);
  setName("랩풀다운");
  };

  const handleIncrement = (e) => {
    console.log(e);
    setCount(count+1);
    setName("스쿼트");
  };

  return (
    <>
      <li className="workout">
        <span className="workout-name">{name}</span>
        <span className="workout-count">{count}</span>
        <button className="wo-button workout-increase" onClick={handleIncrement}>
          <i className="fas fa-plus-square"></i>
        </button>
        <button className="wo-button workout-decrease" onClick={handleDecrement}>
          <i className="fas fa-minus-square"></i>
        </button>
        <button className="wo-button workout-delete">
          <i className="fas fa-trash"></i>
        </button>
      </li>
    </>
  );
}

export default Workout;