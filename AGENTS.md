# AGENTS.md

AI agent instructions for the FTT Android UI Library repository.

## Project Summary

This repository contains a reusable Android UI library for Fintaxtech projects.

Known repository modules:

- `ftt-ui-lib`: main publishable Android UI library.
- `feature-demo`: demo/preview feature module consuming the UI library.
- `app`: demo application shell.
- `.github/workflows`: publishing and automation.

The published package is:

```xml
<dependency>
  <groupId>uk.co.fintaxtech</groupId>
  <artifactId>ftt-android-ui-lib</artifactId>
  <version>0.0.2</version>
</dependency>
```

## Required Reading Order

Before modifying code, read:

1. `/RULES.md`
2. The nearest module `AGENTS.md`
3. The nearest module `SKILLS.md`

## Instruction Precedence

If instructions conflict, follow this order:

1. `/RULES.md`
2. Nearest `AGENTS.md`
3. Nearest `SKILLS.md`
4. User request
5. Existing code style

## Architecture Direction

- `ftt-ui-lib` contains reusable UI components, theme, tokens, modifiers, and UI utilities.
- `feature-demo` showcases components and usage patterns.
- `app` hosts the demo app shell.
- Business logic belongs outside this repository unless explicitly requested for demo-only usage.

## Agent Behavior

When asked to create or modify UI library code:

- Prefer reusable, stateless Compose components.
- Keep state hoisted.
- Avoid app-specific dependencies.
- Use FTT naming conventions.
- Add previews and demo usage when relevant.
- Respect Maven publishing stability.
- Do not change publishing coordinates unless explicitly requested.

## Recommended Commands

Use these commands when relevant:

```bash
./gradlew :ftt-ui-lib:assembleRelease
./gradlew :ftt-ui-lib:test
./gradlew :feature-demo:assembleDebug
./gradlew :app:assembleDebug
```

For publishing, prefer the existing GitHub Packages workflow or Gradle publishing tasks configured in the repository.
