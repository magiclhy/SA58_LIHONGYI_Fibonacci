import React, { useState } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [targetAmount, setTargetAmount] = useState('');
  const [coinDenominations, setCoinDenominations] = useState('');
  const [result, setResult] = useState([]);
  const [error, setError] = useState('');

  const handleCalculate = async () => {
    setError('');
    setResult([]);
    if (!targetAmount || !coinDenominations) {
      setError('Please enter both target amount and coin denominations.');
      return;
    }

    const denominations = coinDenominations.split(',').map(Number);
    if (denominations.some(isNaN)) {
      setError('Coin denominations must be a comma-separated list of numbers.');
      return;
    }

    try {
      const response = await axios.post('http://localhost:8080/api/coin-calculator/calculate', {
        targetAmount: parseFloat(targetAmount),
        coinDenominations: denominations
      });
      setResult(response.data);
    } catch (error) {
      console.error('Error calculating coins:', error);
      setError('Error calculating coins. Please check your inputs and try again.');
    }
  };

  return (
    <div className="App">
      <h1>Coin Calculator</h1>
      <div className="form-group">
        <label>Target Amount:</label>
        <input
          type="number"
          step="0.01"
          value={targetAmount}
          onChange={(e) => setTargetAmount(e.target.value)}
          className="form-control"
        />
      </div>
      <div className="form-group">
        <label>Coin Denominations (comma-separated):</label>
        <input
          type="text"
          value={coinDenominations}
          onChange={(e) => setCoinDenominations(e.target.value)}
          className="form-control"
        />
      </div>
      <button onClick={handleCalculate} className="btn btn-primary">Calculate</button>
      {error && <p className="error">{error}</p>}
      <div>
        <h2>Result:</h2>
        <div className="result-list">
          {result.map((coin, index) => (
            <span key={index} className="result-item">{coin}</span>
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;