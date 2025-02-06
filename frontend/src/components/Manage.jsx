import '../css/Manage.css'

function Manage() {
    return(
        <div className="Manage-content">
            <div className="Manage-content-s1">
                <h2>Add a book</h2>
                <div className="Manage-content-s1-addSection">
                    <div className="Manage-content-s1-addSection-title">
                        <label for="">Title*</label>
                        <input type="text" className="Section-input addSection-input-title"/>
                    </div>
                    <div className="Manage-content-s1-addSection-title">
                        <label htmlFor="">Author*</label>
                        <input type="text" className="Section-input addSection-input-author"/>
                    </div>
                    <div className="Manage-content-s1-addSection-title">
                        <label htmlFor="">Genre*</label>
                        <input type="text" className="Section-input addSection-input-genre"/>
                    </div>
                    <div className="Manage-content-s1-addSection-title">
                        <label htmlFor="">Publish Date</label>
                        <input type="date" className="Section-input addSection-input-date"/>
                    </div>
                    <div className="Manage-content-s1-addSection-title">
                        <label htmlFor="">Price*</label>
                        <input type="number" className="Section-input addSection-input-price"/>
                    </div>
                    <div className="Manage-content-s1-addSection-button">
                        <button className="Section-button">Add</button>
                        <button className="Section-button">Update</button>
                    </div>
                </div>
            </div>
            <div className="Manage-content-s2"></div>
        </div>


    );
}

export default Manage;