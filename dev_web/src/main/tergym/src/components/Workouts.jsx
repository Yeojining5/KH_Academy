import React from 'react';
import Workout from './Workout';

function Workouts(props) {
  console.log(props); // 객체로 받은 경우
  console.log(props.workouts); // 배열
    // 바닐라스크립트에서 함수는 객체이다
    const handleDecrement = (e) => {
      //setCount(count <=0 ? 0: count-1);
      //setName("랩풀다운");
      };
    
      const handleIncrement = (workout) => {
        props.onIncrement(workout);
        //console.log(workout);
        //setCount(count+1);
        //setName("스쿼트");
      };
      const handleDelete = () => {

      };

      return (
        <div className='workouts'>
          <ul>
          {props.workouts.map((workout) => (
              <Workout 
              key={workout.id} 
              workout={workout}/>
            ))
          }        
          </ul>
        </div>
      );
  
}

export default Workouts;