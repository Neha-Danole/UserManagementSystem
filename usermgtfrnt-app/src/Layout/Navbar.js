import React from "react";
import{Link} from "react-router-dom";

export default function Navbar()
{
    return(
        <div >
            <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
                <Link className="navbar-brand" to="/">
                User Management System</Link>
                <button className="navbar-toggler"
                        type="button"
                        data-bs-toggle="collpase"
                        data-bs-target="navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle-navigation"
                        >
                            <span className="navbar-toggle-icon"></span>
                </button>
                <div className="ms-auto mx-2">

                <Link className="btn btn-outline-light" to="/addusers">Add user</Link>

</div>
            </nav>
        </div>
    )
}