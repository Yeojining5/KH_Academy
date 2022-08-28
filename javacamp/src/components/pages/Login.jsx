import React from "react";
import { Container, Nav, Navbar, NavDropdown } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

function Login({ authService }) {
  const navigate = useNavigate();
  const moveMain = (userId) => {
    navigate({ pathname: "/main/" + userId });
  };
  const handleLogin = (event) => {
    //authService.login("Google").then(console.log);
    authService
      .login("Google") //
      .then((data) => moveMain(data.user.uid));
  };
  return (
    <>
      <Navbar bg="light" expand="lg">
        <Container>
          <Navbar.Brand href="#home">자바캠프</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
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
                  navigate("/hacker");
                }}
              >
                해커뉴스
              </Nav.Link>
              <NavDropdown title="로그인" id="basic-nav-dropdown">
                <NavDropdown.Item onClick={handleLogin}>
                  Google
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.2">
                  Another action
                </NavDropdown.Item>
                <NavDropdown.Item href="#action/3.3">
                  Something
                </NavDropdown.Item>
                <NavDropdown.Divider />
                <NavDropdown.Item href="#action/3.4">
                  Separated link
                </NavDropdown.Item>
              </NavDropdown>
            </Nav>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
}

export default Login;
