import "./app.css";
import { React, useState } from "react";
import { Container, Navbar, Nav, Button } from "react-bootstrap";
import { Link, Route, Routes, useNavigate } from "react-router-dom";
import styled from "styled-components";
import TentPage from "./components/pages/TentPage";
import goods from "./tentData.js";

/* let BtnColor = styled.button`
  background: ${(props) => props.bgc};
  color: ${(props) => (props.bgc === "yellow" ? "black" : "white")};
  padding: 5px;
`; */

function BootStrapApp(props) {
  // 변수 선언 위치, 함수 선언 위치
  // 상태관리를 위해 제공되는 훅(16.8버전 후에 지원: 이전 함수로는 state관리가 불가)
  let [tents, setTents] = useState(goods);
  let navigate = useNavigate(); // 함수형 프로그래밍 지향 - 클래스가 아닌 훅으로 처리함
  return (
    <>
      {/* ########################## Header Start ########################## */}
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="#home">JavaCamp</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link
              onClick={() => {
                navigate("/");
              }}
            >
              Home
            </Nav.Link>
            <Nav.Link
              onClick={() => {
                navigate("/tents");
              }}
            >
              텐트
            </Nav.Link>
            <Nav.Link href="#pricing">매트/침낭</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      {/* ########################## Header End ########################## */}

      <div className="main-bg"></div>
      <Routes>
        <Route path="/" element={<div>홈페이지 입니다.</div>} />
        <Route path="/tents" element={<TentPage tents={tents} />} />
      </Routes>
    </>
  );
}

export default BootStrapApp;

