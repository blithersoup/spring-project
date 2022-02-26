import { Outlet, Link } from "react-router-dom";
import App from "./App";
import StackEx from "./Results.js";
import Feature from "./Try.js";

const Layout = () => {
  return (
    <>
      <nav>
        <ul>
          <li>
            <Link to="/">App</Link>
          </li>
          <li>
            <Link to="/results">StackEx</Link>
          </li>
          <li>
            <Link to="/try">Feature</Link>
          </li>
        </ul>
      </nav>

      <Outlet />
    </>
  );
};

export default Layout;
