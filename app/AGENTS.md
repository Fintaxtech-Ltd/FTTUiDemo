# app/AGENTS.md

Instructions for the demo app module.

## Module Purpose

`app` is the demo application shell for the FTT UI library.

## Responsibilities

- Application entry point
- Demo navigation host
- App-level theme setup for demos
- Wiring demo feature modules

## Forbidden

- Do not add reusable UI library components here.
- Do not add publishing logic here.
- Do not put business/domain/data architecture here.

## Rules

- Keep the app small.
- Use it only to host and verify library demos.
- Do not make library components depend on this app.
