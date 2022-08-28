const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component{
    constructor(props)
    {
        super(props);
        this.state = {
            items:[],
            isLoaded: false,
            newName: '',
            newCardNumber: '',
            newLimit: 0,
            successfullyAdded: true,
            errorMessage: '',
        }

       this.handleChange = this.handleChange.bind(this);
       this.handleSubmit = this.handleSubmit.bind(this);
    }

    getAllCardInfo()
    {
         fetch('http://localhost:8080/CardInfo/GetAll')
            .then(res => res.json())
            .then(json => {
                this.setState(
                {
                    isLoaded: true,
                    items: json,
                    newName: '',
                    newCardNumber: '',
                    newLimit: 0,
                })
            });
    };

    componentDidMount()
    {
        this.getAllCardInfo();
    }

    handleSubmit(e)
    {
       e.preventDefault();
       this.addCard(this.state.newName, this.state.newCardNumber, this.state.newLimit);
       this.getAllCardInfo();
    }

    addCard = async (newName, newNumber, newLimit) => {
        await fetch('http://localhost:8080/CardInfo/Add', {
             method: 'POST',
             body: JSON.stringify({
                 name: newName,
                 cardNumber: newNumber,
                 limit: newLimit
            }),
      headers: {
         'Content-type': 'application/json; charset=UTF-8',
      },
   })
      .then((response) => response.json())
      .then((data) => {
            console.log(data.Success);
            console.log(data.Message);

            if(data.Success)
            {
                this.getAllCardInfo()
            }

             this.setState(
                 {
                     successfullyAdded: data.Success,
                     errorMessage: data.Message,
                 })
      })
      .catch((err) => {
         console.log(err.message);
      });
    }

    handleChange(event)
    {
       if(event.target.id == 'nameInput')
       {
              this.setState({newName: event.target.value});
       }
       else if (event.target.id == 'numberInput')
       {
              this.setState({newCardNumber: event.target.value});
       }
       else
       {
             this.setState({newLimit: event.target.value});
       }

    }

    render()
    {
        var{isLoaded, items } =  this.state;

       let message;
       if(!this.state.successfullyAdded)
       {
            message = <p id = "errorMessage">{this.state.errorMessage}</p>;
       }

        if(!isLoaded)
        {
            return <div>Loading..</div>
        }
        else
        {
            return(
                <div className="App">
                <h1>Credit card system</h1>
                <div>
                   <h2>Add</h2>
                       <form class ="submitForm" onSubmit={this.handleSubmit}>
                          <label> Name:</label><br/>
                          <input id = "nameInput" type="text" value={this.state.newName} placeholder="Name" onChange={this.handleChange} /><br/>
                          <label> Card Number: </label><br/>
                          <input id = "numberInput" type="number" value={this.state.newCardNumber} placeholder="Card number" onChange={this.handleChange} /><br/>
                          <label> Limit: </label><br/>
                          <input id = "limitInput" type="number" value={this.state.newLimit} placeholder="Card Limit" onChange={this.handleChange} /><br/>
                          <input class="submitButton" type="submit" value="Submit" /><br/>
                      </form>
                       {message}
                </div>
                <h2>Existing Cards</h2>
                <table id = "Detailstable">
                    <tr>
                		<th>Name</th>
                		<th>Card Number</th>
                		<th>Balance</th>
                		<th>Limit</th>
                	</tr>
                	{items.map(item =>
                     (
                	    <tr>
                    	    <td>{item.name}</td>
                    	    <td>{item.cardNumber}</td>
                    	    <td>{item.balance}</td>
                    	    <td>{item.limit}</td>
                        </tr>
                   ))};
                   </table>
                </div>
            );
        }
    }
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)