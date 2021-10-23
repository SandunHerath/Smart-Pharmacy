import React, { useState, useEffect } from "react";
import axios from "axios";
import { Row, Col } from "react-bootstrap";
import Product from "../components/Medicine";
const MedicinesScreen = () => {
  //   let products = [];
  const [products, setProducts] = useState([]);
  const getData = async () => {
    const { data } = await axios.get("/api/medicine/");
    setProducts(data);
  };
  useEffect(() => {
    getData();
  }, []);

  return (
    <>
      <h1>Latest Products</h1>

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
