import React, { useState, useEffect } from "react";
import axios from "axios";
import { Row, Col, Button } from "react-bootstrap";
import Product from "../components/Medicine";
const MedicinesScreen = ({ history }) => {
  //   let products = [];
  const [products, setProducts] = useState([]);
  const getData = async () => {
    const { data } = await axios.get("/api/medicine/");
    setProducts(data);
  };
  useEffect(() => {
    getData();
  }, []);

  const addNewHandler = () => {
    history.push("/medicine/add");
  };
  return (
    <>
      <h1>Latest Medicines</h1>
      <Button onClick={addNewHandler} className="btn-block" type="button">
        Add New Medicine
      </Button>
      <Row>
        {/* <p>{products[0].id}</p> */}
        {products.map((product) => (
          <Col key={product.id} sm={12} md={6} lg={4} xl={3}>
            <Product product={product} />
          </Col>
        ))}
      </Row>
    </>
  );
};

export default MedicinesScreen;
