import React from 'react';
import styled from "styled-components"

const BottomH4 = styled.h4`
  color: white;
`;
function Bottom(props) {
  return (
    <>
    <nav className="navbar fixed-bottom bg-dark">
      <div className="container-fluid">
        <BottomH4>자바 개발자 훈련소</BottomH4>
      </div>
    </nav> 
    </>
  );
}

export default Bottom;