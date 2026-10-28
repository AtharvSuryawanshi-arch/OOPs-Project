import { useEffect, useState } from 'react'

export default function App() {
  const [result, setResult] = useState('Loading...')

  useEffect(() => {
    fetch('/api/ping')
      .then((r) => {
        if (!r.ok) throw new Error('HTTP ' + r.status)
        return r.json()
      })
      .then((d) => setResult(JSON.stringify(d, null, 2)))
      .catch((e) => setResult('FAILED: ' + e.message))
  }, [])

  return (
    <div style={{ fontFamily: 'sans-serif', padding: 24 }}>
      <h1>I-ITSM environment check</h1>
      <p>Environment de-update</p>
      <pre>{result}</pre>
    </div>
  )
}
