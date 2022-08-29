import React from "react";

function TentDetail(props) {
  const tent = props.tent;
  return (
    <div className="col-md-4">
      <img src={process.env.PUBLIC_URL + "/images/" + tent.img} width="80%" />
      <h4>{tent.title}</h4>
      <p>{tent.content}</p>
      <p>{tent.price}원</p>
      <button className="btn btn-danger">주문하기</button>
    </div>
  );
}

export default TentDetail;
