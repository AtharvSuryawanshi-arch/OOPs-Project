# I-ITSM – environment skeleton

## Team versions
| Component   | Version |
|-------------|---------|
| PostgreSQL  | 18.6 (`postgres:18.6-alpine`) |
| Spring Boot | 4.1.1 (Maven) |
| Java        | 25 (Temurin) |
| React       | 19.3.0 |
| Vite        | 8.3.4 (with @vitejs/plugin-react ^6.0.2) |
| Node (local / build) | 22.12+ |

## One-time setup
1. `cp .env.example .env`   (Windows: `copy .env.example .env`)
2. Recommended: `cd frontend && npm install`, then commit the generated `package-lock.json`.
   (The frontend Dockerfile falls back to `npm install` if the lock file is missing.)

## Run everything in containers
    docker compose up --build
Open http://localhost:3000 – you should see JSON with "status": "ok" and the PostgreSQL version.

## Test ladder
1. `docker compose up -d db`  then `docker compose ps` (should be "healthy")
2. `docker compose up --build`
3. Dev mode: `docker compose up -d db`, run backend from IDE (uses localhost:5433),
   then `cd frontend && npm run dev` -> http://localhost:5173

## Notes
- If DB credentials change after first run: `docker compose down -v` (deletes DB data).
- Rebuild just the backend: `docker compose up --build -d backend`
- Local (non-Docker) development needs JDK 25 and Node 22.12+.
