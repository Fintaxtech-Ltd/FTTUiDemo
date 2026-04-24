# ftt-ui-lib/AGENTS.md

Instructions for the main FTT Android UI library module.

## Module Purpose

`ftt-ui-lib` is the reusable Android UI library distributed as:

```xml
<dependency>
  <groupId>uk.co.fintaxtech</groupId>
  <artifactId>ftt-android-ui-lib</artifactId>
  <version>0.0.2</version>
</dependency>
```

## Responsibilities

This module may contain:

- Reusable Jetpack Compose components
- FTT theme wrappers
- Color, typography, spacing, shape, and elevation tokens
- Reusable modifiers
- UI-only helper utilities
- Preview/sample-only composables
- Compose UI tests

This module must not contain:

- Business logic
- ViewModels
- Repositories
- Use cases
- Retrofit, Room, DataStore
- App navigation logic
- App-specific screens
- Feature-specific domain models

## Component Design Rules

- Prefer stateless composables.
- Hoist state to callers.
- Always expose a `modifier: Modifier = Modifier` parameter where useful.
- Use Material 3 and FTT design tokens.
- Do not hardcode business strings.
- Keep parameters simple and consumer-friendly.
- Avoid exposing unnecessary implementation details.
- Public APIs must be stable and documented enough for consumers.

## File Organization

Recommended packages:

```text
uk.co.fintaxtech.ui
├── components
│   ├── button
│   ├── textfield
│   ├── card
│   ├── toolbar
│   └── dialog
├── theme
│   ├── color
│   ├── typography
│   ├── spacing
│   └── shape
├── modifier
├── preview
└── util
```

Adapt to the existing project structure if it differs.

## Previews

- Add previews for visual components.
- Wrap previews in `FTTTheme`.
- Include light/dark previews when relevant.
- Keep preview-only sample data local/private.

## Accessibility

- Interactive components must support semantics.
- Icon-only interactions need content descriptions unless null is intentionally correct.
- Components must not block accessibility/custom font scaling.

## Testing

- Add Compose UI tests for interactive behavior.
- Add unit tests for pure functions/utilities.
- Test names follow `action_condition_expectedResult`.
