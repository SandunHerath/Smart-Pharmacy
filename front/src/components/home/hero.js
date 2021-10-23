import React from "react";
import { Button } from "antd";
import { Link } from "react-router-dom";
import { Carousel } from "antd";

const items = [
  {
    key: "1",
    title: "Welcome to Smart-Medical-Center",
    content:
      "An vim odio ocurreret consetetur, justo constituto ex mea. Quidam facilisis vituperata pri ne. Id nostrud gubergren urbanitas sed, quo summo animal qualisque ut, cu nostro dissentias consectetuer mel. Ut admodum conceptam mei, cu eam tation fabulas abhorreant. His ex mandamus.",
  },
  {
    key: "2",
    title: "Welcome to Smart-Medical-Center",
    content:
      "An vim odio ocurreret consetetur, justo constituto ex mea. Quidam facilisis vituperata pri ne. Id nostrud gubergren urbanitas sed, quo summo animal qualisque ut, cu nostro dissentias consectetuer mel. Ut admodum conceptam mei, cu eam tation fabulas abhorreant. His ex mandamus.",
  },
  {
    key: "3",
    title: "Welcome to Smart-Medical-Center",
    content:
      "An vim odio ocurreret consetetur, justo constituto ex mea. Quidam facilisis vituperata pri ne. Id nostrud gubergren urbanitas sed, quo summo animal qualisque ut, cu nostro dissentias consectetuer mel. Ut admodum conceptam mei, cu eam tation fabulas abhorreant. His ex mandamus.",
  },
];

function AppHero() {
  return (
    <div id="hero" className="heroBlock">
      <Carousel>
        {items.map((item) => {
          return (
            <div key={item.key} className="container-fluid">
              <div className="content">
                <h3>{item.title}</h3>
                <p>{item.content}</p>
                <div className="btnHolder">
                  <Link to="/register">
                    <Button type="primary" size="large">
                      Get Medicine
                    </Button>
                  </Link>

                  <Link to="/register">
                    <Button size="large">
                      <i className="fas fa-desktop"></i> Chanel a Doctor
                    </Button>
                  </Link>
                </div>
              </div>
            </div>
          );
        })}
      </Carousel>
    </div>
  );
}

export default AppHero;
