import React from "react";
import { Link } from "react-router-dom";
import { Card } from "react-bootstrap";
import Rating from "./Rating";

const Medicine = ({ product }) => {
  return (
    <Card className="my-3 p-3 rounded">
      <Link to={`/doctor/${product.id}`}>
        <Card.Img src={product.image} variant="top" />
      </Link>

      <Card.Body>
        <Link to={`/doctor/${product.id}`}>
          <Card.Title as="div">
            <strong>{product.name}</strong>
          </Card.Title>
        </Link>

        <Card.Text as="div">
          <Rating
            value={product.rating}
            text={`${product.numReviews} reviews`}
            color="blue"
          />
        </Card.Text>

        <Card.Text as="h5">Hospital :{product.hospital}</Card.Text>
        <Card.Text as="h5">Gender:{product.gender}</Card.Text>
      </Card.Body>
    </Card>
  );
};

export default Medicine;
