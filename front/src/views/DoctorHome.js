import React, { useState, useEffect } from "react";
import axios from "axios";
import { Row, Col, Button } from "react-bootstrap";
import Product from "../components/MyDoctor";
const DoctorsScreen = ({ history }) => {
  const [products, setProducts] = useState([]);
  const getData = async () => {
    const { data } = await axios.get("/api/doctor");
    setProducts(data);
  };
  useEffect(() => {
    getData();
  }, []);
  const addNewHandler = () => {
    history.push("doctor/add");
  };
  return (
    <>
      <h1>Best Doctors</h1>
      <Button onClick={addNewHandler} className="btn-block" type="button">
        Add New Doctor
      </Button>
      <Row>
        {products.map((product) => (
          <Col key={product.id} sm={12} md={6} lg={4} xl={3}>
            <Product product={product} />
          </Col>
        ))}
      </Row>
    </>
  );
};

export default DoctorsScreen;
