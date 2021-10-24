import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { Row, Col, Image, ListGroup, Card, Button } from "react-bootstrap";
import Rating from "../components/Rating";

const DoctorScreen = ({ history, match }) => {
  const [product, setProduct] = useState({});
  const getData = async () => {
    const { data } = await axios.get(`/api/doctor/${match.params.id}`);
    console.log(data);
    setProduct(data);
  };
  useEffect(() => {
    getData();
  }, []);
  const updateHandler = async (e) => {
    history.push("/doctor/edit/" + match.params.id);
  };

  const deleteHandler = async (e) => {
    const { data } = await axios.delete(`/api/doctor/${match.params.id}`);
    console.log(data);
    if(data != null){
      alert("successfully deleted !")
    }
    history.push("/doctors");
  };
  return (
    <>
      <Link className="btn btn-light my-3" to="/doctors">
        Go Back
      </Link>

      <Row>
        <Col md={6}>
          <Image src={product.image} alt={product.name} fluid />
        </Col>
        <Col md={3}>
          <ListGroup variant="flush">
            <ListGroup.Item>
              <h3>{product.name}</h3>
            </ListGroup.Item>
            <ListGroup.Item>
              <Rating value={product.rating} text={` reviews`} />
            </ListGroup.Item>
            <ListGroup.Item>Hospital: {product.hospital}</ListGroup.Item>
            <ListGroup.Item>Category: {product.category}</ListGroup.Item>
          </ListGroup>
          <ListGroup.Item>
            <Button onClick={updateHandler} className="btn-block" type="button">
              Update
            </Button>
            <Button onClick={deleteHandler} className="btn-block" type="button">
              Delete
            </Button>
            
          </ListGroup.Item>
        </Col>
      </Row>
    </>
  );
};

export default DoctorScreen;
