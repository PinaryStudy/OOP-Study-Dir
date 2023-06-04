import './style.css'
import { setupCounter } from './counter.ts'

document.querySelector<HTMLDivElement>('#app')!.innerHTML = `
  <h1>Hello Vite!</h1>
`

setupCounter(document.querySelector<HTMLButtonElement>('#counter')!)
