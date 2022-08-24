import React from "react";
import { useParams } from "react-router-dom";
import TentDetail from "./TentDetail";

function TentPage(props) {
  const tents = props.tents;
  console.log(tents);
  const { id, name } = useParams();
  //console.log(id + ", " + name);
  return (
    <div className="container mt-5">
      <div className="row">
        {tents.map((tent, i) => (
          <TentDetail key={i} tent={tent} />
        ))}
      </div>
    </div>
  );
}

export default TentPage;
